import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import MediCartProvider from './Store/MediCartProvider';

import Login from './Components/Login/Login';
import SignUpPage from './Layout/SignUpPage';

import Footer from './Layout/Footer';
import Header from './Layout/Header';
import Home from './Layout/Home';
import Information from './Layout/Information';

import MediPeople from './Layout/MediPeople';
import MyBox from './Layout/MyBox';
import NotFound from './Layout/NotFound';

import Write from './Layout/Write';
import ItemRegisterContainer from "./containers/ItemRegisterContainer"
import ItemModifyContainer from "./containers/ItemModifyContainer"
import ItemReadContainer from "./containers/ItemReadContainer"



function App() {
  let isAuthorized = sessionStorage.getItem("isAuthorized");
  // Modal.setAppElement('#root')
  return (
    <div className="App">
      <BrowserRouter>
      <Header />
      <main className='main'> 

        <Routes>
          <Route path="/" element={<Home />}></Route>
          <Route path="/information" element={<Information/>}></Route>
          <Route path="/login" element={<Login/>}></Route>
          <Route path="/medipeople" element={<MediPeople />}></Route>
          <Route path="/mybox" element={<MyBox />}></Route>
          <Route path="/signuppage" element={<SignUpPage/>}></Route>
          <Route path="/write" element={<Write/>}></Route>
          <Route path="/create" element={<ItemRegisterContainer/>}></Route>
          <Route path="/edit/:itemId" element={<ItemModifyContainer/>}></Route>
          <Route path="/read/:itemId" element={<ItemReadContainer/>}></Route>

          <Route path="/*" element={<NotFound />}></Route>
        </Routes>
      </main>
      </BrowserRouter>
      <Footer/>
    </div>
  );
}

export default App;
