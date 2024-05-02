import {useState, useEffect} from 'react';
import { geMenuList } from '../api/MenuAPI';

function Menu(){

    const [menuList, setMenuList]=useState([]);

    useEffect(
        ()=>{},
        []
    );

    return(
        <h1>판매 메뉴목록</h1>
    );
}
export default Menu;