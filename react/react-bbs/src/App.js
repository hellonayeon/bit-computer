import { BrowserRouter } from "react-router-dom";

import Header from "./Components/app/Header"
import Nav from "./Components/app/Nav"
import Main from "./Components/app/Main"
import Footer from "./Components/app/Footer"
import AuthProvider from "./Components/context/AuthProvider"
import { createContext } from "react";



function App() {

  const AuthContext = createContext({
    isAuth: false,
    id: null
  });

  return (
    <div>
      <BrowserRouter>
        
        <Header />
        
        <AuthProvider>
          <Nav />
          <Main />
        </AuthProvider>

        <Footer />

      </BrowserRouter>
    </div>
  );
}

export default App;
