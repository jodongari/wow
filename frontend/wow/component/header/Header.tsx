import React from 'react';
import {Icon} from 'semantic-ui-react'
import styles from "../../styles/Header.module.css"

const Header = () => {
    return (
        <div>
            <span className={styles.myMenu}>
                <img src="http://placehold.it/100x50"/>
            </span>
            <span >
                <Icon name='video camera' size='big' className={styles.icon}/>
                <Icon name='bell' size='big' className={styles.icon}/>
                <Icon name='user' size='big' className={styles.icon}/>
            </span>
        </div>
    );
};

export default Header;
