import { Link, redirect, useNavigate } from 'react-router-dom'
import { useEffect, useState } from 'react';
import {useForm} from 'react-hook-form'
import {z} from 'zod'
import { zodResolver } from '@hookform/resolvers/zod';
import notvisible from "../assets/images/notvisible.png"
import visibleeye from "../assets/images/visible.png"



/** 
* @typedef {z.infer<typeof schema>} Login
*/ 
const schema = z.object({
  username: z.string().min(8, { message : "Username must be 8 characters minimum"}),
  password: z.string().min(8, { message : "Password must be 8 characters minimum"}),

});

function LoginPage() {
  const navigate = useNavigate();
  const {register, handleSubmit, 
    setError,
    formState:{errors, isSubmitting}, reset} = useForm(
      {
        resolver: zodResolver(schema),
      }
    
  );

  const [visible,setVisible] = useState(false);
  const [remember,setRemember]= useState(false);
  

useEffect(() => {
  // add To input values when remember is true
  
}, [])

 

  const  onSubmit = async (data) => { 
      // handle axios call to get our user data from our backend
      // Use the isSubmitting boolean to handle async function
    try {
      await new Promise((resolve) => setTimeout(resolve,2000))
      // add data to localStorage 

      console.log(data)
      navigate("/dashboard");
    } catch (error) {

      reset()
      setError("root", {

        message: "Error",
      });
    }
  
  }

  const handleChange = (e) =>{
     setRemember( e.target.checked)
  }
  useEffect(() => {
    console.log("remember: ", remember);
    
  }, [remember])
  

  
   
  return (
    <>
  <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <div className="w-full max-w-md p-8 space-y-2 bg-white rounded-lg shadow-lg">
        <h2 className="text-2xl font-bold text-center text-gray-800">Login</h2>
        
        <form className="space-y-4" onSubmit={handleSubmit(onSubmit)} >
          <div>
            <label className="block mb-1 text-sm font-medium text-gray-600" htmlFor="username">
              Username
            </label>
            <input
            placeholder='username '
            className="w-full px-3 py-2 text-gray-800 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
            {...register("username")}
            />
          {errors.username && <div className="text-red-500">{errors.username.message}</div>}
          </div>

          <div className='relative'>
            <label className="block mb-1 text-sm font-medium text-gray-600" htmlFor="password">
              Password
            </label>
            <input
            type={visible ? "text" : "password" }
            className="w-full px-3 py-2 text-gray-800 border border-gray-300 rounded-lg focus:outline-none focus:border-indigo-500"
            {...register("password")}
            placeholder='password '
            />
          <img src={visible? visibleeye: notvisible} alt="" className='absolute h-6 w-6 right-[1.5rem] top-[2.1rem] ' 
          onClick={() => setVisible((prevState) => !prevState)} />
          </div>
          {errors.password && (<div className="text-red-500">{errors.password.message}</div>)}

        <button type='submit'
            className="w-full px-4 py-2 text-white bg-indigo-500 rounded-lg hover:bg-indigo-600 focus:outline-none"
          disabled= {isSubmitting}
          >
            Log In
        </button>
        </form>
        <button
            className="w-full px-4 py-2 text-white bg-indigo-500 rounded-lg hover:bg-indigo-600 focus:outline-none"
          >
                       <Link to={"register"}>Register a new account</Link>
          </button>
        <div className='flex flex-row gap-2'>
            <input type="checkbox" name="remember"  onChange={handleChange}  />
            <p className='grow' >Remember Me</p>
            <Link to={"forgotpass"} >forgot password?</Link>
        </div>
        {errors.root && <div className="text-red-500">{errors.root.message}</div>}
      </div>
    </div>


    </>

  )
}

export default LoginPage