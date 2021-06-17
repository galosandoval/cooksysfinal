import styled from "styled-components";

export const StyledProjects = styled.div`
  padding: 15px 0;
  color:black;
  display: flex;
  background: #f8f8f8;
  .projects-container {
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  .card-container {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
  }
`;
export const EditProjectInput = styled.input`
border-color: black;
padding: 5px ;
border-radius: 5px;
border: 1px solid #ccc;
   width:90%;s
   border:;
   color: ;
   background: white;
   textalign: center;
   font-size:15px;
   margin:8px;
 &::placeholder{
     color: gray;
     &:focus{
         outline:none;
     }
 }
`