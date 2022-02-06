import React, {useEffect, useRef} from 'react';
import Head from 'next/head';
import Dashjs from "dashjs";
import {GetServerSideProps, GetStaticProps} from "next";
import axios from "axios";



const About = () => {
    let player;
    init();

    return (
        <>
            {/*<Head>*/}
            {/*    <script async src="http://cdn.dashjs.org/v3.1.0/dash.all.min.js"></script>*/}
            {/*</Head>*/}
            <div>
                {/* eslint-disable-next-line react/no-string-refs */}
                <video controls={true}/>
            </div>
        </>
    );
};

export const getStaticProps: GetStaticProps = async (context) => {
    init();

    // 실제 서비스 로직
    /*
    data.apiUrl = apiUrl;
     */

    return {
        props: {
            name: process.env.name,
        },
    }
}

const init = () => {
    let video,
        player,
        url = "https://dash.akamaized.net/akamai/bbb_30fps/bbb_30fps.mpd";

    video = document.querySelector("video");
    console.log(video);
    // eslint-disable-next-line react-hooks/rules-of-hooks
    player = Dashjs.MediaPlayer().create();

    /* Extend RequestModifier class and implement our own behaviour */
    // @ts-ignore
    player.extend("RequestModifier", () => {
        return {
            modifyRequestHeader: function (xhr: any) {
                /* Add custom header. Requires to set up Access-Control-Allow-Headers in your */
                /* response header in the server side. Reference: https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/setRequestHeader */
                // xhr.setRequestHeader('X-VIDEO-HASH', '');
                return xhr;
            },
            modifyRequestURL: (url: any) => {
                /* Modify url adding a custom query string parameter */
                return url + '?customQuery=value';
            }
        };
    });

    // @ts-ignore
    player.initialize(video, url, true);
}



export default About;
