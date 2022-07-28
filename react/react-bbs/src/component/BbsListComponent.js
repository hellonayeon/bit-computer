import React, {useEffect, useState} from "react";
import axios from "axios";
import BbsTableRowComponent from "./BbsTableRowComponent";

const BbsListComponent = () => {
    
    const [bbsList, setBbsList] = useState([]);

    useEffect( () => {

        const getBbsList = async () => {
            await axios.get("http://localhost:3000/getBbsList", {})
            .then((resp) => {
                console.log("success /getBbsList");
                console.log(resp.data);
        
                setBbsList(resp.data);
            })
            .catch((err) => {
                console.log("error /getBbsList");
                console.log(err);
        
                
            });
        }

        getBbsList();
        
    }, [])

    


    return (
        <>
            <table border="1">
                <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>조회수</th>
                    <th>작성자</th>
                </tr>	
                </thead>
                <tbody>	
                    {
                        bbsList.map((bbs, i) => {
                            return (
                                <BbsTableRowComponent 
                                    obj={bbs} key={i} cnt={i+1} />
                            );
                        })
                    }
                    
                </tbody>
            </table>

        </>
    );
}

export default BbsListComponent;