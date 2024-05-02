import { BrowserRouter, Routes, Route} from "react-router-dom";
import Layout from "./layouts/Layout";
import About from "./pages/About";
import Main from "./pages/Main";
import Menu from "./pages/Menu";
import MenuDetails from "./pages/MenuDetails";
import MenuSearchResult from "./pages/MenuSearhResult";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout/>}>
          <Route index element={<Main/>}/>
          <Route path="/about" element={<About/>}/>
          <Route path="/menu">
            <Route index element={<Menu/>}/>
            <Route path=":menuCode" element={<MenuDetails/>}/>
            <Route path="search" element={<MenuSearchResult/>}/>
          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
