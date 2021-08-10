import Navbar from "components/Navbar";
import Admin from "pages/Admin";
import Home from "pages/Home";
import VideoList from "pages/VideoList";
import { BrowserRouter, Route, Switch } from "react-router-dom";

const Routes = () => (
    <BrowserRouter>
        <Navbar />
        <Switch>
            <Route path="/" exact>
                <Home />
            </Route>
            <Route path="/videos">
                <VideoList />
            </Route>
            <Route path="/admin">
                <Admin />
            </Route>
        </Switch>
    </BrowserRouter>
);

export default Routes;