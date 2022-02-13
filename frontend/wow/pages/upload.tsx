import React, {useState} from 'react';
import {Button} from "semantic-ui-react";
import axios from "axios";

// Router Test 용으로 이후 Upload Page 를 구현할 예정입니다.
const Upload = () => {

    const [videoFile, setVideoFile] = useState([]);
    const [videoName, setVideoName] = useState("");
    const [description, setDescription] = useState("");

    let video: any;

    const onFileUploadHandler = (e: any) => {

        setVideoFile(e.target.files[0]);
        setVideoName(e.target.files[0].name);
        video = e.target.files[0]
        console.log(e.target.files[0]);
        console.log("나와라 비디오");
        console.log(videoFile);
        console.log(video);

        console.log(e.target.files[0].name);
        // setVideoName(videoFile.name);
    }

    const onClickUploadListener = (e: any) => {
        console.log("업로드 버튼을 클릭했습니다");
        const fd = new FormData();
        fd.append("video", video);
        fd.append("videoName", videoName);
        fd.append("description", "sample description");

        // axios.post('http://localhost:3000/api/video/v1/upload', fd, {
        //     headers: {
        //                 "Content-Type": `multipart/form-data; `,
        //              },
        // }).then(res => {
        //     console.log(res);
        // })

        axios(
          {
            url: 'http://localhost:3000/api/video/v1/upload',
            method: 'post',
            headers: {
              "Content-Type": `multipart/form-data`,
            },
            data: {
                video: video,
                videoName: videoName,
                description: "sample Description"
            },
            // baseURL: 'http://localhost:8080'
            //withCredentials: true,
          }
        ).then(function (response) {
         console.log(response)
        });
    }

    return (
        <div>
            <input type={"file"} id={"videoFile"} onChange={onFileUploadHandler}/>
            <Button onClick={onClickUploadListener}>업로드</Button>
        </div>
    );
};

export default Upload;
