import { Link } from 'react-router-dom';

export default function Navbar() {
  return (
    <header className="navbar">
      <div>
        <h2>Employee HR Portal</h2>
        <p>Manage employee records, departments and salary details</p>
      </div>
      <nav>
        <Link to="/">Dashboard</Link>
        <Link className="primary-link" to="/add">Add Employee</Link>
      </nav>
    </header>
  );
}
