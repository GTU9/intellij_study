import {useState, useEffect} from 'react';
import { geMenuList } from '../api/MenuAPI';
import MenuItem from '../components/MenuItem';
import boxStyle from './Menu.module.css';
import { useNavigate } from 'react-router-dom';


function Menu(){

    const [menuList, setMenuList]=useState([]);
    const [searchValue, setSearchValue]=useState('');

    const navigate=useNavigate();

    useEffect(
        ()=>{
            setMenuList(geMenuList());
        },
        []
    );

    const onClickHandler=()=>{
        /*
            퀴리스트링 형태로 검색어를 전달 
            /menu/search?menuName=밥
        */

            navigate(`/menu/search?menuName=${searchValue}`)

    }

    console.log(menuList);

    return(
        <div>
            <div>
                <input 
                    type="search"
                    name="menuname"
                    value={searchValue}
                    onChange={e=>setSearchValue(e.target.value)}
                />
                <button onClick={onClickHandler}>검색</button>
            </div>
            <h1>판매 메뉴목록</h1>
                <div className={boxStyle.MenuBox}>
                    {menuList.map(menu=><MenuItem key={menu.menuCode} menu={menu}/>)}
                </div>
        </div>
    );
}
export default Menu;