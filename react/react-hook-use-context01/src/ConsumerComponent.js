import React, {useContext} from "react";

// 데이터를 넘겨 받을 컴포넌트
const ConsumerComponent = () => {
    const humanData = useContext();
    
    console.log(humanData);

    return (
        <>
            <h5>[ConsumerComponent - humanData] {humanData}</h5>
        </>
    );
}

export default ConsumerComponent;