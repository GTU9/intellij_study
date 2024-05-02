import { NavLink } from 'react-router-dom';

function Navbar(){

    const activeStyle={
        backgroundColor: 'orangered'
    };

    return(
        <div>
            <li><NavLink to="/" style={({isActive})=> isActive ? activeStyle : undefined}>HOME</NavLink></li>
            <li><NavLink to="/about" style={({isActive})=> isActive ? activeStyle : undefined}>소개</NavLink></li>
            <li><NavLink to="/menu" style={({isActive})=> isActive ? activeStyle : undefined}>메뉴 목록</NavLink></li>
        </div>
        
    );
}

export default Navbar;