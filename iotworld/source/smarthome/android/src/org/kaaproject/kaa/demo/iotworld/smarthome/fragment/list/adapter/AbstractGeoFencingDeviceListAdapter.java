/**
 *  Copyright 2014-2016 CyberVision, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.kaaproject.kaa.demo.iotworld.smarthome.fragment.list.adapter;

import org.kaaproject.kaa.demo.iotworld.geo.OperationMode;
import org.kaaproject.kaa.demo.iotworld.smarthome.R;
import org.kaaproject.kaa.demo.iotworld.smarthome.data.AbstractGeoFencingDevice;
import org.kaaproject.kaa.demo.iotworld.smarthome.data.DeviceStore;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public abstract class AbstractGeoFencingDeviceListAdapter<T extends AbstractGeoFencingDevice> 
    extends AbstractDeviceListAdapter<T> {

    public AbstractGeoFencingDeviceListAdapter(
            RecyclerView recyclerView,
            DeviceStore deviceStore,
            DeviceSelectionListener deviceSelectionListener) {
        super(recyclerView, deviceStore, deviceSelectionListener);
    }

    static abstract class ViewHolder<T extends AbstractGeoFencingDevice> extends AbstractDeviceListAdapter.ViewHolder<T> {

        private TextView geoFencingStatusView;
        
        public ViewHolder(View itemView) {
            super(itemView);
            geoFencingStatusView = (TextView) itemView.findViewById(R.id.geoFencingStatus);
        }
        
        @Override
        public void bind(T device) {
            super.bind(device);
            OperationMode mode = device.getOperationMode();
            if (mode == null) {
                mode = OperationMode.OFF;
            } 
            int pos = AbstractGeoFencingDevice.getOperationModePosition(mode);
            geoFencingStatusView.setText(
                    geoFencingStatusView.getResources().getStringArray(R.array.geofencing_status)[pos]);
        }

    }
}
