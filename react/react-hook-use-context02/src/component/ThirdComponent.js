import React, {useContext} from "react";
import {TextContext} from "./TextProvider";

function ThirdComponent() {

    const textData = useContext(TextContext); // TextProvider 로 부터 값을 전달받음

    return (
        <div>
            <h5>Third Component</h5>
            <h5> {textData} </h5>
        </div>
    );
}

export default ThirdComponent;