import {Menu, Segment} from 'semantic-ui-react'
import {NextPage} from "next";

const Nav: NextPage = () => {

    const activeItem: string = 'home';
    return (
        <Segment inverted>
            <Menu inverted pointing secondary>
                <Menu.Item
                    name='home'
                    active={activeItem === 'home'}
                />
                <Menu.Item
                    name='messages'
                    active={activeItem === 'messages'}
                />
                <Menu.Item
                    name='friends'
                    active={activeItem === 'friends'}
                />
            </Menu>
        </Segment>
    )
}

export default Nav
