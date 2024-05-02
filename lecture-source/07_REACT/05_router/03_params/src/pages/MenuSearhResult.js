import {useEffect,useState} from 'react';
import {useSearchParams} from 'react-router-dom';
import {searchMenu} from '../api/MenuAPI';

function MenuSearchResult(){

    const [searchParams]=useSearchParams();

    const[menuList, setMenuList]=useState([]);

    const menuName=searchParams.get('menuName');

    useEffect(
        ()=>{
            setMenuList();
        },
        [menuName]
    )
    return(
        <div>
            <h1>검색된 메뉴</h1>
            <div className={boxStyle.menuBox}>
                {menuList.map(menu=><MenuItem key={menu.menuCode} menu={menu}/>)}
            </div>
        </div>
    );
}

export default MenuSearchResult;