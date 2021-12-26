import {Menu, Segment} from 'semantic-ui-react'
import {NextPage} from "next";

const NavBar: NextPage = () => {

    const activeItem: string = 'home';
    return (
        <Segment inverted>
            <Menu inverted pointing secondary>
                <Menu.Item
                    name='home'
                    active={activeItem === 'home'}
                    // onClick={this.handleItemClick}
                />
                <Menu.Item
                    name='messages'
                    active={activeItem === 'messages'}
                    // onClick={this.handleItemClick}
                />
                <Menu.Item
                    name='friends'
                    active={activeItem === 'friends'}
                    // onClick={this.handleItemClick}
                />
            </Menu>
        </Segment>
    )
}

export default NavBar