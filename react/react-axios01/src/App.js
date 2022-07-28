import React, {useEffect, useState} from "react";
import axios from "axios";

function App() {

  const [members, setMembers] = useState([]);

  useEffect( () => {
    const fetchData01 = async () => {
      const response = await axios.get("http://localhost:3000/base", {});
      console.log(response.data);
    }

    const fetchData02 = async () => {
      const response = await axios.get("http://localhost:3000/member", {});
      console.log(response.data);
      console.log(response.data.id);
    }

    const fetchData03 = async () => {
      const response = await axios.get("http://localhost:3000/conn-param",
                                        { params: {"title": "제목입니다", "num": 248} });
      console.log(response.data);
    }

    const fetchData04 = async () => {
      const response = await axios.post("http://localhost:3000/conn-param-obj", null,
                                        { params: {"id": "hellonayeon", "pwd": "qwerty!"} });
      console.log(response.data);
    }

    const fetchData05 = async () => {
      await axios.get("http://localhost:3000/db-test", {})
      .then(function(response) { // success (func)
        console.log(response.data);
        setMembers(response.data);
      })
      .catch((err) => { // catch (anonymous)
        alert(err);
      })
    }

    fetchData01();
    fetchData02();
    fetchData03();
    fetchData04();
    fetchData05();
  }, []);
  

  return (
      <>
        <table border="1">
          <thead>
            <tr>
              <th>NUM</th>
              <th>ID</th>
              <th>PWD</th>
              <th>NAME</th>
              <th>EMAIL</th>
            </tr>
          </thead>
          <tbody>
            {
              members.map(function (obj, i) {
                return (

                  // <tr>
                  //   <th>{i}</th>
                  //   <th>{obj.id}</th>
                  //   <th>{obj.pwd}</th>
                  //   <th>{obj.name}</th>
                  //   <th>{obj.email}</th>
                  // </tr>

                  <TableRow obj={obj} key={i} cnt={i+1}>

                  </TableRow>
                )
              })
            }
          </tbody>
        </table>
      </>
  );
}

function TableRow(props) {

  return (
    <tr>
      <th>{props.cnt}</th>
      <td>{props.obj.id}</td>
      <td>{props.obj.pwd}</td>
      <td>{props.obj.name}</td>
      <td>{props.obj.email}</td>
    </tr>
  );

}

export default App;
