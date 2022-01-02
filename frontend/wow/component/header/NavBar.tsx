import {Menu, Segment} from 'semantic-ui-react'
import {NextPage} from "next";
import Link from "next/link";
import React, {useState} from "react";
import {useRouter} from "next/router";

const NavBar: NextPage = () => {
    const router = useRouter();
    const [activeItem, setActiveItem] = useState('home');

    const changeActiveItem = (menuItem: string) => {
        setActiveItem(menuItem)
        if(menuItem === "home"){
            router.push("/");
        } else if(menuItem === 'about'){
            router.push("/about")
        }
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
                <Link href="/about">
                <Menu.Item
                    name='about'
                    active={activeItem === 'about'}
                    onClick={() => changeActiveItem('about')}
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
