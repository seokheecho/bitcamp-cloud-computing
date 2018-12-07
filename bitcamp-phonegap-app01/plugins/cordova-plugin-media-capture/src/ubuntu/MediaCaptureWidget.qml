/*
 *
 * Copyright 2013 Canonical Ltd.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
*/
import QtQuick 2.0
import QtMultimedia 5.0

Rectangle {
    property string recordOffImagePath: "record_off.png"
    property string recordOnImagePath: "record_on.png"
    property string shootImagePath: "shoot.png"
    function isSuffix(str, suffix) {
        return String(str).substr(String(str).length - suffix.length) == suffix
    }

    id: ui
    color: "#252423"
    anchors.fill: parent
    state: "off"

    Camera {
        objectName: "camera"
        id: camera
        onError: {
            console.log(errorString);
            shootButton.source = recordOffImagePath
        }
        imageCapture {
            onImageSaved: {
                root.exec("Capture", "onImageSaved", [path]);
                ui.destroy();
            }
        }
        videoRecorder {
            audioBitRate: 128000
            mediaContainer: "mp4"
            outputLocation: ui.parent.plugin('Capture').generateLocation("mp4")
            onRecorderStateChanged: {
               if (videoRecorder.recorderState === CameraRecorder.StoppedState) {
                   ui.parent.exec("Capture", "onVideoRecordEnd", [camera.videoRecorder.outputLocation]);
                   shootButton.source = recordOffImagePath
               }
            }
        }
    }
    Image {
        id: microphoneImage
        source: "microphone.png"
        smooth: true
        visible: false
        width: parent.width
        height: parent.height
    }
    VideoOutput {
        id: output
        focus : visible
        source: camera
        width: parent.width
        height: parent.height
    }

    Item {
        anchors.bottom: parent.bottom
        width: parent.width
        height: shootButton.height
        BorderImage {
            id: leftBackground
            anchors.left: parent.left
            anchors.top: parent.top
            anchors.bottom: parent.bottom
            anchors.right: middle.left
            anchors.topMargin: units.dp(2)
            anchors.bottomMargin: units.dp(2)
            source: "toolbar-left.png"
            Image {
                anchors.verticalCenter: parent.verticalCenter
                anchors.left: parent.left
                anchors.leftMargin: parent.iconSpacing
                source: "back.png"
                width: units.gu(6)
                height: units.gu(5)
                MouseArea {
                    anchors.fill: parent
                    onClicked: {
                        root.exec("Capture", "cancel");
                    }
                }
            }
        }
        BorderImage {
            id: middle
            anchors.top: parent.top
            anchors.bottom: parent.bottom
            anchors.horizontalCenter: parent.horizontalCenter
            height: shootButton.height + units.gu(1)
            width: shootButton.width
            source: "toolbar-middle.png"
            Image {
                id: shootButton
                width: units.gu(8)
                height: width
                anchors.horizontalCenter: parent.horizontalCenter
                source: shootImagePath
                MouseArea {
                    anchors.fill: parent
                    onClicked: {
                        if (ui.state === "camera") {
                            camera.imageCapture.captureToLocation(ui.parent.plugin('Capture').generateLocation("jpg"));
                        } else if (ui.state === "audio") {
                            ui.parent.exec("Capture", "recordAudio");
                            if (isSuffix(shootButton.source, recordOffImagePath)) {
                                shootButton.source = recordOnImagePath
                            } else {
                                shootButton.source = recordOffImagePath
                            }
                        } else if (ui.state === "videoRecording") {
                            if (!camera.videoRecorder.recorderState) {
                                shootButton.source = recordOnImagePath
                                camera.videoRecorder.record();
                            } else {
                                camera.videoRecorder.stop();
                            }
                        }
                    }
                }
            }
        }
        BorderImage {
            id: rightBackground
            anchors.right: parent.right
            anchors.top: parent.top
            anchors.bottom: parent.bottom
            anchors.left: middle.right
            anchors.topMargin: units.dp(2)
            anchors.bottomMargin: units.dp(2)
            source: "toolbar-right.png"
        }
    }
    states: [
        State {
            name: "off"
            StateChangeScript {
                script:{
		    ui.visible = false;
                    camera.stop();
                    camera.unlock();
                }
            }
        },
        State {
            name: "camera"
            StateChangeScript {
                script: {
                    camera.start();
		    microphoneImage.visible = false
                    output.visible = true
                    shootButton.source = shootImagePath
                    ui.visible = true
                }
            }
        },
        State {
            name: "videoRecording"
            StateChangeScript {
                script: {
                    shootButton.source = recordOffImagePath
                    camera.start();
		    microphoneImage.visible = false
                    output.visible = true
                    ui.visible = true
                }
            }
        },
        State {
            name: "audio"
            StateChangeScript {
                script:{
                    shootButton.source = recordOffImagePath
                    camera.stop();
		    microphoneImage.visible = true
                    camera.unlock();
                    output.visible = false
                    ui.visible = true
                }
            }
        }
    ]
}
