import React from 'react';
import {Icon} from 'semantic-ui-react'
import styles from "../../styles/Header.module.css"

const Header = () => {
    return (
        <div>
            <span>
                <img src="http://placehold.it/100x50"/>
            </span>
            <div className={styles.myMenu}>
                <span className={styles.icon}>
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
