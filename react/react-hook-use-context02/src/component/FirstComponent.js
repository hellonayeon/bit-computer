import React, {useContext} from "react";
import SecondComponent from "./SecondComponent";
import {TextContext} from "./TextProvider";

function FirstComponent() {

    const textData = useContext(TextContext); // TextProvider 로 부터 값을 전달받음

    return (
        <div>
            <h5>First Component {textData}</h5>

            <SecondComponent/>
        </div>
    );
}

export default FirstComponent;