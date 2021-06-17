import styled from 'styled-components'

const StyledMemberPage = styled.div `
display: flex;
background: #f8f8f8;
.member-page-container {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.card-container {
  display: flex;
  flex-wrap: wrap;
  width: 100%;
}
.member-page-container .card {
  border: 1px solid red;
}
`

export const CreateP = styled.button`
display: inline-block;
justify-content: center;
margin: 50px 0px -10px 0px;
padding: 5px 5px 5px 5px ;
border-radius: 5px;
border: 1px solid #ccc;
`

export default StyledMemberPage