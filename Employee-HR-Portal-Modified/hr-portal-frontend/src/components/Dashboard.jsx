import { useEffect, useMemo, useState } from 'react';
import { Link } from 'react-router-dom';
import { deleteEmployee, getEmployees, searchEmployees } from '../api.js';

export default function Dashboard() {
  const [employees, setEmployees] = useState([]);
  const [keyword, setKeyword] = useState('');

  const loadEmployees = async () => {
    const response = await getEmployees();
    setEmployees(response.data);
  };

  useEffect(() => { loadEmployees(); }, []);

  const totalSalary = useMemo(() => employees.reduce((sum, emp) => sum + Number(emp.salary || 0), 0), [employees]);
  const departments = useMemo(() => new Set(employees.map(emp => emp.department).filter(Boolean)).size, [employees]);

  const handleSearch = async () => {
    if (!keyword.trim()) return loadEmployees();
    const response = await searchEmployees(keyword);
    setEmployees(response.data);
  };

  const handleDelete = async (id) => {
    if (confirm('Delete this employee record?')) {
      await deleteEmployee(id);
      loadEmployees();
    }
  };

  return (
    <main className="container">
      <section className="cards">
        <div className="card"><span>Total Employees</span><strong>{employees.length}</strong></div>
        <div className="card"><span>Departments</span><strong>{departments}</strong></div>
        <div className="card"><span>Monthly Payroll</span><strong>₹{totalSalary.toLocaleString('en-IN')}</strong></div>
      </section>

      <section className="panel">
        <div className="panel-header">
          <h2>Employee Directory</h2>
          <div className="search-box">
            <input value={keyword} onChange={(e) => setKeyword(e.target.value)} placeholder="Search name or department" />
            <button onClick={handleSearch}>Search</button>
          </div>
        </div>

        <div className="table-wrapper">
          <table>
            <thead>
              <tr>
                <th>Name</th><th>Email</th><th>Department</th><th>Designation</th><th>Salary</th><th>Joining</th><th>Phone</th><th>Action</th>
              </tr>
            </thead>
            <tbody>
              {employees.map(emp => (
                <tr key={emp.id}>
                  <td>{emp.firstname} {emp.lastname}</td>
                  <td>{emp.email}</td>
                  <td>{emp.department}</td>
                  <td>{emp.designation}</td>
                  <td>₹{Number(emp.salary || 0).toLocaleString('en-IN')}</td>
                  <td>{emp.joiningDate}</td>
                  <td>{emp.phone}</td>
                  <td className="actions">
                    <Link to={`/edit/${emp.id}`}>Edit</Link>
                    <button onClick={() => handleDelete(emp.id)}>Delete</button>
                  </td>
                </tr>
              ))}
              {employees.length === 0 && <tr><td colSpan="8">No employees found</td></tr>}
            </tbody>
          </table>
        </div>
      </section>
    </main>
  );
}
