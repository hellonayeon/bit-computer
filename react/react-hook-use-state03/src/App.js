import "./style.css";
import FavoriteFruit from "./component/selectComp.js";
import FavoriteColor from "./component/radioComp.js";


  // select: 좋아하는 과일
  // radio : 좋아하는 과자
  
 
function App() {

  return (
    <div className="App">
        <FavoriteFruit/>
        <FavoriteColor/>
    </div>
  );
}

export default App;
