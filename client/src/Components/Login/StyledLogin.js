import styled from "styled-components";

export const StyledLogin = styled.div`
  height: 100vh;
  background: #f8f8f8;
  display: grid;
  place-items: center;
  .login-container {
    padding: 100px;
    text-align: center;
    background-color: white;
    border-radius: 2px;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
  }
  .hide {
    display: none;
  }
`;


export const SignUpB = styled.button`
display:flex;
margin:10px 1px 1px 1px;
text-align: center;
padding: 5px 25px 5px 25px ;
border-radius: 5px;
border: 1px solid #ccc;
font-size:15px;
`

export const CompanySignUpB = styled.button`
display:flex;
margin:4px 1px 1px 1px;
text-align: center;
padding: 5px 0px 5px 0px ;
border-radius: 5px;
border: 1px solid #ccc;
font-size:15px;
`

export const SignUpForm = styled.div`
width:150px;
display: inline-block;
` 