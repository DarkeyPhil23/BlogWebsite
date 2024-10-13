import React from 'react'
import { useEffect, useState } from 'react';
import MainBodyComp from '../components/IndexPageComponents/MainBodyComp';
import axios from 'axios'


const IndexPage = () => {
  const [posts, setPosts] = useState([]);
 
  useEffect (() => {
    axios.get('http://localhost:8080')
    .then(res => setPosts(res.data.content) )
    .then(console.log(posts))
    .catch(err => <p>{err} has been reached :P</p>)
  }, [])

  return (
    <>
    <main className='flex justify-center align-middle bg-slate-700 m-auto pr-2'>
      <div className=" bg-red-600 w-3/4">
        <div className="bg-blue-500  mx-8 my-8 max-h-full h-4/5">
          {
            posts.map((post) => <MainBodyComp key={post.id} id = {post.id} title = {post.title} post = {post.content}/>
            
          )
          }
        </div>
      </div>
    </main>
    </>
  )
}

export default IndexPage