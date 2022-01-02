import {Menu, Segment} from 'semantic-ui-react'
import {NextPage} from "next";
import Link from "next/link";
import React, {useState} from "react";

const NavBar: NextPage = () => {

    const [activeItem, setActiveItem] = useState('home');

    const changeActiveItem = (menuItem: string) => {
       setActiveItem(menuItem)
    }

    return (
        <Segment inverted>
            <Menu inverted pointing secondary>
                <Link href="/">
                <Menu.Item
                    name='home'
                    active={activeItem === 'home'}
                    onClick={() => changeActiveItem('home')}
                >
                </Menu.Item>
                </Link>
                <Link href="/MyPage">
                <Menu.Item
                    name='messages'
                    active={activeItem === 'messages'}
                    onClick={() => changeActiveItem('messages')}
                />
                </Link>
                <Menu.Item
                    name='friends'
                    active={activeItem === 'friends'}
                    onClick={() => changeActiveItem('friends')}
                />
            </Menu>
        </Segment>
    )
}

export default NavBar
