import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Footer from './Layout/Footer';
import Header from './Layout/Header';
import Home from './Layout/Home';
import Information from './Layout/Information';
import Login from './Layout/Login';
import MediPeople from './Layout/MediPeople';
import MyBox from './Layout/MyBox';
import NotFound from './Layout/NotFound';
import SignIn from './Layout/SignIn';
import Write from './Layout/Write';



function App() {
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
    <Route path="/signin" element={<SignIn/>}></Route>
    <Route path="/write" element={<Write/>}></Route>

    <Route path="/*" element={<NotFound />}></Route>
    </Routes>
    </main>
    </BrowserRouter>
  <Footer/>
    </div>
  );
}

export default App;
