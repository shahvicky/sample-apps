#
#  Copyright 2014-2016 CyberVision, Inc.
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.
#

cmake_minimum_required(VERSION 2.8.8)

project (C-SDK-sample)
enable_language(C)

find_package (OpenSSL REQUIRED)

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -std=gnu99 -g -Wall -Wextra")

include_directories(${CMAKE_CURRENT_SOURCE_DIR}/src
                    ${CMAKE_CURRENT_SOURCE_DIR}/libs/kaa/src
                   )

link_directories(${CMAKE_CURRENT_SOURCE_DIR}/build)

set (SAMPLE_SOURCE_FILES
            src/kaa_demo.c
)

add_executable(${APP_NAME} ${SAMPLE_SOURCE_FILES})
target_link_libraries(${APP_NAME} kaac crypto)
