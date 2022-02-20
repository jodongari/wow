import React, {useState} from 'react';
import {Button} from "semantic-ui-react";
import axios from "axios";

// Router Test 용으로 이후 Upload Page 를 구현할 예정입니다.
const Upload = () => {

    const [videoFile, setVideoFile] = useState('');
    const [videoName, setVideoName] = useState('');
    const [description, setDescription] = useState('');

    const onFileUploadHandler = (e: any) => {
        e.preventDefault();
        setVideoFile(e.target.files[0]);
        setVideoName(e.target.files[0].name);
        setDescription("test description");
    };

    const onClickUploadListener = (e: any) => {
        const fd = new FormData();
        fd.append("video", videoFile);
        fd.append("videoName", videoName);
        fd.append("description", description);

        axios.post('http://localhost:3000/api/video/v1/upload', fd, {
            headers: {
                        "Content-Type": "application/json",
                     },
        }).then(res => {
            console.log(res);
        })
    };

    return (
        <div>
            <input type={"file"} id={"videoFile"} onChange={onFileUploadHandler}/>
            <Button onClick={onClickUploadListener}>업로드</Button>
        </div>
    );
};

export default Upload;
