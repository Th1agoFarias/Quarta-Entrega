import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import Api from '../../Api/Api';
import './cliente.css'

export default function Index() {
  const [clientes, setClientes] = useState([]);
  const [redirect, setRedirect] = useState(false);


 

  useEffect(() => {
    Api.get('/clientes')
      .then((response) => {
        setClientes(response.data);
        setRedirect(false);
      })
      .catch((error) => {
        console.log(error);
      });

      
  }, [redirect]);

      function deleteCliente(id){
      Api.delete(`/clientes/${id}`)
      setRedirect(true);}
  

  return (
    <>
      <header className="header">
        <h1 className="container d-flex "><strong>CLIENTES</strong> </h1>
      </header>
      <div className="container p-3">
      
      <Link to="/Clientes-Create" className="btn btn-primary mb-3">
         <strong>NOVO CADASTRO</strong>
        </Link>
       
        <div className="table-responsive d-flex  ">
          <table className="table table-hover table-sm table-colors">
            <thead>
              <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Nascimento</th>
              </tr>
            </thead>  
            <tbody>
              
              {clientes.map((cliente) => (
                <tr className="text-white" key={cliente.id}>
                  <td className="text-white">{cliente.id}</td>
                  <td className="text-white">{cliente.nome}</td>
                  <td className="text-white">{cliente.cpf}</td>
                  <td className="text-white">{cliente.nascimento}</td>
                  

                  <td className="d-flex justify-content-end">
                    <Link
                      to={`/Clientes-Update/${cliente.id}`}
                      className="btn btn-info"
                    >
                      EDITAR
                    </Link>
                    <button
                      className="btn btn-danger"
                      onClick={() => deleteCliente(cliente.id)}
                      style={{ marginLeft: "10px" }}
                    >
                      DELETAR
                    </button>
                  </td>
                 
                </tr>
                
              ))}
            </tbody>
            
          </table>
          
        </div >
      
       
      </div>
    </>
  );
}
