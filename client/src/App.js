import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Login from './Components/Login/Login';
import SignUp from './Components/Login/SignUp';
import Footer from './Layout/Footer';
import Header from './Layout/Header';
import Home from './Layout/Home';
import Information from './Layout/Information';

import MediPeople from './Layout/MediPeople';
import MyBox from './Layout/MyBox';
import NotFound from './Layout/NotFound';

import Write from './Layout/Write';



function App() {
  return (
    <div className="App">
    <BrowserRouter>
    <Header />
    <Routes>
    <Route path="/" element={<Home />}></Route>
    <Route path="/information" element={<Information/>}></Route>
    <Route path="/login" element={<Login/>}></Route>
    <Route path="/medipeople" element={<MediPeople />}></Route>
    <Route path="/mybox" element={<MyBox />}></Route>
    <Route path="/signup" element={<SignUp/>}></Route>
    <Route path="/write" element={<Write/>}></Route>

    <Route path="/*" element={<NotFound />}></Route>
    </Routes>
    </BrowserRouter>
  <Footer/>
    </div>
  );
}

export default App;
