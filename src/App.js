
import AllRoutes from './AllRoutes';
import './App.css';
import {BrowserRouter as Router } from 'react-router-dom';
import Index from './frontend/index.jsx';
function App() {
  return (
    <div className="App">
      <Router>
        <Index />
        <AllRoutes />
      </Router>
      
    </div>
  );
}

export default App;
