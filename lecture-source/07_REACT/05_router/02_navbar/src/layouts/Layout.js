import Header from "../components/Header";
import Navbar from "../components/Navabr";
import {Outlet} from 'react-router-dom';

function Layout(){
    return(
        <>
            <Header/>
            <Navbar/>
            <Outlet/>
        </>
    )
}

export default Layout;