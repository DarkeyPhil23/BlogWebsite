import React from 'react'
{
  /*
    TODO: Make our api call be limited only to three and then render that as only three 
  
  */
}

const IndexPage = () => {
  return (
    <>
    <main className='flex justify-center align-middle bg-slate-700 m-auto max-h-svh h-screen pr-2'>
      <div className=" bg-red-600 w-3/4">
        <div className="bg-blue-500 max-w-4x1 mx-8 my-8 max-h-4xl h-4/5">
        <div className="flex flex-col gap-4 bg-orange-700">
          <h1 className='self-center'>Hello From H1</h1>
          <textarea name="" id="" cols="30" className=' self-center '></textarea>
          <button> <Link to= {'/Post/:id'}> Read More</Link></button>
        </div>
        </div>
      </div>
    </main>
    </>
  )
}

export default IndexPage