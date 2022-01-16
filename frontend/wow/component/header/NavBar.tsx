import {Menu, Segment} from 'semantic-ui-react'
import {NextPage} from "next";
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
                <Menu.Item
                    name='home'
                    active={activeItem === 'home'}
                    onClick={() => changeActiveItem('home')}
                />
                <Menu.Item
                    name='about'
                    active={activeItem === 'about'}
                    onClick={() => changeActiveItem('about')}
                />
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
