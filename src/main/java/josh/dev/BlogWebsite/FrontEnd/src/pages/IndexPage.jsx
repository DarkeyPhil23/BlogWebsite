import React from 'react'
import {Link} from 'react-router-dom'
import MainBodyComp from '../components/IndexPageComponents/MainBodyComp';
{
  /*
    TODO: Make our api call be limited only to three and then render that as only three 
  
  */
}

const IndexPage = () => {
 let postid = 1;
 let title = 'Hello World?'
 let post = 'Adkon yuhi00bzxncjhbguJK sFDBGUH <KMN1>BNHIJK </KMN1>N'
  return (
    <>
    <main className='flex justify-center align-middle bg-slate-700 m-auto max-h-svh h-screen pr-2'>
      <div className=" bg-red-600 w-3/4">
        <div className="bg-blue-500  mx-8 my-8 max-h-full h-4/5">
          <MainBodyComp id = {postid} title = {title} post = {post}/>
        </div>
      </div>
    </main>
    </>
  )
}

export default IndexPage