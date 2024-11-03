import { Link } from 'react-router-dom'
import { useState, React } from 'react';

function LoginPage() {
   
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
  return (
    <>
  <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <div className="w-full max-w-md p-8 space-y-2 bg-white rounded-lg shadow-lg">
        <h2 className="text-2xl font-bold text-center text-gray-800">Login</h2>
        
        <form className="space-y-4" >
          <div>
            <label className="block mb-1 text-sm font-medium text-gray-600" htmlFor="email">
              Email
            </label>
            <input
              type="email"
              id="email"
              className="w-full px-3 py-2 text-gray-800 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
              placeholder="Enter your email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>

          <div>
            <label className="block mb-1 text-sm font-medium text-gray-600" htmlFor="password">
              Password
            </label>
            <input
              type="password"
              id="password"
              className="w-full px-3 py-2 text-gray-800 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
              placeholder="Enter your password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>

          <button
            className="w-full px-4 py-2 text-white bg-indigo-500 rounded-lg hover:bg-indigo-600 focus:outline-none"
          >
            Log In
          </button>
      
        </form>
        <button
            className="w-full px-4 py-2 text-white bg-indigo-500 rounded-lg hover:bg-indigo-600 focus:outline-none"
          >
            Register
          </button>
        <div>
            <input type="checkbox" name="remember"  />
            <p>Remember Me</p>
            <Link to={"forgotpass"}>forgot password?</Link>
        </div>
      </div>
    </div>


    </>

  )
}

export default LoginPage