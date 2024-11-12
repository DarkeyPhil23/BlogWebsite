import React from 'react'

const ForgotPasswordPage = () => {
  // add this one
  return (
    <>
        <div class="flex items-center justify-center min-h-screen bg-gray-100">
          <div class="w-full max-w-md p-8 space-y-6 bg-white rounded-lg shadow-lg">
            <h2 class="text-2xl font-bold text-center text-gray-800">Forgot Password</h2>
            <p class="text-sm text-gray-600 text-center mb-4">
              Enter your email address below and we’ll send you instructions to reset your password.
            </p>

            <form class="space-y-4">
              <div class="relative">
                <label for="email" class="block mb-1 text-sm font-medium text-gray-700">
                  Email Address
                </label>
                <input
                  type="email"
                  id="email"
                  placeholder="Enter your email"
                  class="w-full px-4 py-2 border border-gray-300 rounded-lg text-gray-800 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500"
                  required
                />
              </div>

              <button
                type="submit"
                class="w-full px-4 py-2 text-white bg-indigo-500 rounded-lg hover:bg-indigo-600 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2"
              >
                Submit
              </button>
            </form>
          </div>
        </div>
    </>
  )
}

export default ForgotPasswordPage