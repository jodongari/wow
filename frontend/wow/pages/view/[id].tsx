import React, {useEffect, useState} from 'react';
import {useRouter} from "next/router";
import Axios from 'axios';
import VideoItem from "../../component/video/VideoItem";
import {GetServerSideProps} from "next";
import axios from "axios";

const Post = ({item}: any) => {

    return (
        <VideoItem item ={item}/>
    );
};

export default Post;

export const getServerSideProps: GetServerSideProps = async (context) => {
    const id = context.params?.id; // ?: null 체크
    const apiUrl: string = `http://makeup-api.herokuapp.com/api/v1/products/${id}.json`;
    const res = await axios.get(apiUrl);
    const data = res.data;

    return {
        props: {
            item: data,
            name: process.env.name,
        },
    }
}
