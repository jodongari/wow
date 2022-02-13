import React from 'react';
import Dashjs from "dashjs";
import styles from "/styles/Item.module.css"


const About = () => {
    init();

    return (
        <>
            <div>
                {/* eslint-disable-next-line react/no-string-refs */}
                <video className={styles.icon} controls={true}/>
            </div>
        </>
    );
};

const init = () => {
    let video,
        player,
        url = "https://dash.akamaized.net/akamai/bbb_30fps/bbb_30fps.mpd";

    video = document.querySelector("video");

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
