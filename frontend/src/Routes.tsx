import Navbar from "components/Navbar";
import Admin from "pages/Admin";
import Auth from "pages/Admin/Auth";
import Home from "pages/Home";
import VideoDetails from "pages/VideoDetails";
import VideoList from "pages/VideoList";
import { Router, Redirect, Route, Switch } from "react-router-dom";
import history from "util/history";

const Routes = () => (
    <Router history={history}>
        <Navbar />
        <Switch>
            <Route path="/" exact>
               <Home />
            </Route>
            <Route path="/videos" exact>
                <VideoList />
            </Route>
            <Route path="/videos/:videoId">
                <VideoDetails />
            </Route>
            <Route path="/admin/auth">
                <Auth />
            </Route>
            <Redirect from="/admin" to="/admin/videos" exact />
            <Route path="/admin">
                <Admin />
            </Route>
        </Switch>
    </Router>
);

export default Routes;