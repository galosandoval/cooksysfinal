import "./App.css";
import { Login } from "./Components/Login/Login";
import { Route, Switch } from "react-router-dom";
import { CompanyPage } from "./Screens/CompanyPage/CompanyPage";
import { MemberPage } from "./Screens/MemberPage/MemberPage";
import SignUp from "./Components/SignUp/SignUp";
import { Users } from "./Components/Users/Users";
import { Projects } from "./Components/Projects/Projects";
import CreateProject from "./Components/CreateProject/CreateProject";
// import CreateTeam from "./Components/CreateTeam/CreateTeam";
import CreateProjectSuccess from "./Components/CreateProject/CreateProjectSuccess";
import CompanySignUp from "./Components/SignUp/CompanySignUp";
import EditProject from "./Components/Projects/EditProject"
import ViewProject from "./Components/Projects/ViewProject"
import { Profile } from "./Components/Profile/Profile";

function App() {
  return (
    <div className="App">
      <Switch>
        <Route path="/createprojectsuccess" component={CreateProjectSuccess}/>
        <Route path="/createproject" component={CreateProject}/>
        {/* <Route path="/createteam" component={CreateTeam}/> */}
        <Route path="/member" component={MemberPage} />
        <Route path="/company" component={CompanyPage} />
        <Route path="/SignUp" component={SignUp} />
        <Route path="/CompanySignUp" component={CompanySignUp} />
        <Route path="/users" component={Users} />
        <Route path = "/projects/view/:name" component = {ViewProject}/>
        <Route path="/projects/edit/:name"   component={EditProject} />
        <Route path="/projects" component={Projects} />
      

        <Route path="/profile" component={Profile} />
        <Route path="/" component={Login} />
      </Switch>
    </div>
  );
}

export default App;
