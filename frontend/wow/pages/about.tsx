import React from 'react';
import Head from 'next/head';

const About = () => {
    return (
        <div>
            <h1>This is Test Menu Page</h1>
            <div>
                <Head>
                    <script async src="http://cdn.dashjs.org/v3.1.0/dash.all.min.js"></script>
                </Head>
                <video data-dashjs-player autoPlay src="http://localhost:3000/api/video/v1/videoDownload/mpddash.mpd"
                       controls>
                </video>
            </div>
        </div>
    );
};

export default About;
