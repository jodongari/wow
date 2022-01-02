import React from 'react';
import {Icon} from 'semantic-ui-react'
import styles from "../../styles/Header.module.css"
import {useRouter} from "next/router";

const Header = () => {
    const router = useRouter();

    const moveRouteHandler = (page: string) => {
        if(page === 'upload'){
            router.push('/about')
        }
    }

    return (
        <div>
            <span>
                <img src="http://placehold.it/100x50"/>
            </span>
            <div className={styles.myMenu}>
                <span className={styles.icon} onClick={() => {moveRouteHandler('upload')}}>
                    <Icon name='video camera' size='big' className={styles.icon}/>
                </span>
                <span className={styles.icon}>
                    <Icon name='bell' size='big' className={styles.icon}/>
                </span>
                <span className={styles.icon}>
                    <Icon name='user' size='big' className={styles.icon}/>
                </span>
            </div>
        </div>
    );
};

export default Header;
