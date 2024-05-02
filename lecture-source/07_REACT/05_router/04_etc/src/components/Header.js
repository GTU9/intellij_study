import {NavLink} from 'react-router-dom'

function Navbar(){

    const activeStyle={
        backgorundColor: 'orangered';
    }

    return(
        <div>
            <ul>
                <li><NavLinck to="/" style={({isActive})=> isActive? activeStyle : undefined}>HOME</NavLinck></li>
                <li><NavLinck to="/mypage" style={({isActive})=> isActive? activeStyle : undefined}>마이페이지</NavLinck></li>
                <li><NavLinck to="/login" style={({isActive})=> isActive? activeStyle : undefined}>로그인</NavLinck></li>
            </ul>
        </div>
    )
}