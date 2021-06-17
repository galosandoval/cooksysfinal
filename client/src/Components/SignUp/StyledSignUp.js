import styled from 'styled-components';

export const InspectP = styled.div`
`
export const Styledmain = styled.div`
display: block;
text-align: center;
display: flex;
justify-content: center;
border-style: solid;
height:50%;
`
export const Form = styled.div`
background-color: #f2f2f2;
position: absolute;
left: 50%;
top: 50%;
transform: translate(-50%, -50%);
display:inline-block;
border-style: solid;
width:20%;
margin-left: auto;
margin-right: auto;
text-align: center;
border-radius: 5px;s
`
export const Input = styled.input`
border-color: black;
padding: 5px ;
border-radius: 5px;
border: 1px solid #ccc;
   width:90%;
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
export const Button = styled.button`
display:block;
margin: 20px 0% 20px 30%;
text-align: center;
padding: 5px 25px 5px 25px ;
border-radius: 5px;
border: 1px solid #ccc;
font-size:15px;
`
export const Select = styled.select`
display:block;
margin: 8px 0% 0px 5%;
width: 90%;
padding: 5px 25px 5px 25px ;
border-radius: 5px;
border: 1px solid #ccc;
`


// display:block;
// margin: 8px 0% 0px 5%;
// padding: 5px 25px 5px 25px ;
// border-radius: 5px;
// border: 1px solid #ccc;