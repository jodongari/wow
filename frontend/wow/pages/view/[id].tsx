import React, {useEffect, useState} from 'react';
import {useRouter} from "next/router";
import Axios from 'axios';
import VideoItem from "../../component/video/VideoItem";

const Post = () => {
    const router = useRouter();
    const {id} = router.query;

    const [item, setItem] = useState({});
    const API_URL = `http://makeup-api.herokuapp.com/api/v1/products/${id}.json`

    const getData = () => {
        Axios.get(API_URL)
            .then((res: any) => {
                setItem(res.data);
            })
    }

    useEffect(()=>{
        getData();
    }, [id]);

    return (
        <VideoItem item={item}/>
    );
};

export default Post;
