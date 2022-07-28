

const BbsTableRowComponent = (props) => {
    
    return (
        <tr>
            <th>{props.cnt}</th>
            <td>{props.obj.title}</td>
            <td>{props.obj.readcount}</td>
            <td>{props.obj.id}</td>
        </tr>
    );

}

export default BbsTableRowComponent;
