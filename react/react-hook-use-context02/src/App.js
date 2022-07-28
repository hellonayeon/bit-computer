import React, {createContext} from "react";
import FirstComponent from './component/FirstComponent';
import TextProvider from "./component/TextProvider"

function App() {
  return (
    <>
      <TextProvider>
          <FirstComponent />
      </TextProvider>
    </>
  );
}

export default App;
